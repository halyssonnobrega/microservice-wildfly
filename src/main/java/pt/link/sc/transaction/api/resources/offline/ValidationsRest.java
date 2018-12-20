package pt.link.sc.transaction.api.resources.offline;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import pt.link.sc.transaction.api.business.entity.ChannelPointEO;
import pt.link.sc.transaction.api.business.entity.OfflineCardOperationEO;
import pt.link.sc.transaction.api.business.service.ChannelPointService;
import pt.link.sc.transaction.api.business.service.OfflineCardOperationService;
import pt.link.sc.transaction.api.common.util.CsvUtil;
import pt.link.sc.transaction.api.resources.model.CsvTransactions;
import pt.link.sc.transaction.api.resources.model.RegisterTransactionsResponse;
import pt.link.sc.transaction.api.resources.model.ReloadTransaction;
import pt.link.sc.transaction.api.resources.model.ValidationTransaction;

@RestController
@RequestMapping("/api/offline/validation")
@Api(tags = {"Validations"}, authorizations = {@Authorization(value = "OAuth2-Enterprise", scopes = {@AuthorizationScope(description = "Enterpise", scope = "public"),})}
)
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ValidationsRest {
	
	@Inject
    private OfflineCardOperationService offlineCardOperationService;
	
	@Inject
    private ChannelPointService channelPointService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(nickname = "registerValidations", value = "Validation transactions registration on the SIIT", notes = ".")
    @ApiResponses({@ApiResponse(code = 400, message = "Failed to validate successfully the transaction structures sent by the request.")})
    public RegisterTransactionsResponse registerValidations(@RequestBody @ApiParam(allowEmptyValue = false, name = "validations", value = "The csv transactions to register on the BCSC. Only accepts debit and invalidation transactions. If any other is sent the request will be rejected.") 
    														 @Valid CsvTransactions csvTransactions) {


        Assert.notNull(csvTransactions, "csvTransactions is required");
        Assert.notNull(csvTransactions.getCsvTransactions(), "csvTransactions list is required");
        List<ValidationTransaction> transactions = csvTransactions.getCsvTransactions().stream().map(x -> (ValidationTransaction) CsvUtil.processCsv(x.getCsv(), x.getCorrelationId(), x.getLocationDescription())).collect(Collectors.toList());

        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ValidationTransaction>> validate = new HashSet<>();
        for (ValidationTransaction t : transactions) {
            validate.addAll(validator.validate(t));
        }

        if (!validate.isEmpty()) {
            throw new ConstraintViolationException(validate);
        }

        ChannelPointEO channelPoint = channelPointService.mapToChannelPoint(csvTransactions.getChannelPointId(), csvTransactions.getChannelPointDescription()).orElse(null);
        
        //FIXME: adapt to validations 
        OfflineCardOperationEO offlineCardOperation = offlineCardOperationService.registerOfflineCardTransactions(transactions.toArray(new ReloadTransaction[0]), csvTransactions.getCorrelationId(), channelPoint);
        RegisterTransactionsResponse response = new RegisterTransactionsResponse();
        response.setUuid(offlineCardOperation.getUuid());
        return response;
    }
}
