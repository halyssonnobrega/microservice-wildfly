package pt.link.sc.transaction.api.business.dto;

import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang3.tuple.Pair;

import pt.link.sc.transaction.api.business.entity.AuthorizationEO;
import pt.link.sc.transaction.api.common.enums.InvalidOperationCode;

public class CardAuthorizationResultDto {
	private final AuthorizationEO resultedAuthorization;
	private final List<Pair<InvalidOperationCode, Object[]>> generatedWarnings;

	@Generated("SparkTools")
	private CardAuthorizationResultDto(Builder builder) {
		this.resultedAuthorization = builder.resultedAuthorization;
		this.generatedWarnings = builder.generatedWarnings;
	}

	public AuthorizationEO getResultedAuthorization() {
		return resultedAuthorization;
	}

	public List<Pair<InvalidOperationCode, Object[]>> getGeneratedWarnings() {
		return generatedWarnings;
	}

	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	@Generated("SparkTools")
	public static final class Builder {
		private AuthorizationEO resultedAuthorization;
		private List<Pair<InvalidOperationCode, Object[]>> generatedWarnings = Collections.emptyList();

		private Builder() {
		}

		public Builder withResultedAuthorization(AuthorizationEO resultedAuthorization) {
			this.resultedAuthorization = resultedAuthorization;
			return this;
		}

		public Builder withGeneratedWarnings(List<Pair<InvalidOperationCode, Object[]>> generatedWarnings) {
			this.generatedWarnings = generatedWarnings;
			return this;
		}

		public CardAuthorizationResultDto build() {
			return new CardAuthorizationResultDto(this);
		}
	}

}