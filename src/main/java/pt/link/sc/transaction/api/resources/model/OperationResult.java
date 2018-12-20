package pt.link.sc.transaction.api.resources.model;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.tuple.Pair;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pt.link.sc.transaction.api.common.enums.InvalidOperationCode;

@ApiModel(description = "An error message related to a specific field")
public class OperationResult {

    @ApiModelProperty(value = "The HTTP code returned in the server response", example = "500")
    @NotNull
    private int httpCode;

    private List<String> warnings = new ArrayList<>();

    public OperationResult(int httpCode, List<Pair<InvalidOperationCode, Object[]>> warnings) {
        this.httpCode = httpCode;
        if (warnings != null) {
            final ResourceBundle messageBundle = ResourceBundle.getBundle("messages", Locale.FRENCH);
            for (Pair<InvalidOperationCode, Object[]> p : warnings) {
                try {
                    this.warnings.add(MessageFormat.format(messageBundle.getString(p.getKey().name()), p.getValue()));
                } catch (MissingResourceException e) {
                    this.warnings.add(MessageFormat.format(p.getKey().name(), p.getValue()));
                }
            }
        }

    }

}
