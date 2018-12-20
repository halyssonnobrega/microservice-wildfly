package pt.link.sc.transaction.api.business.dto;

import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang3.tuple.Pair;

import pt.link.sc.transaction.api.common.enums.InvalidOperationCode;

public class CardOperationResultDto {
	
	private final CardInformationDto cardCurrentInformationDto;
	private final List<Pair<InvalidOperationCode, Object[]>> generatedWarnings;

	@Generated("SparkTools")
	private CardOperationResultDto(Builder builder) {
		this.cardCurrentInformationDto = builder.cardCurrentInformationDto;
		this.generatedWarnings = builder.generatedWarnings;
	}

	public CardInformationDto getCardCurrentInformationDto() {
		return cardCurrentInformationDto;
	}

	public List<Pair<InvalidOperationCode, Object[]>> getGeneratedWarnings() {
		return generatedWarnings;
	}

	/**
	 * Creates builder to build {@link CardOperationResultDto}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link CardOperationResultDto}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private CardInformationDto cardCurrentInformationDto;
		private List<Pair<InvalidOperationCode, Object[]>> generatedWarnings;

		private Builder() {
		}

		public Builder withCardCurrentInformationDto(CardInformationDto cardCurrentInformationDto) {
			this.cardCurrentInformationDto = cardCurrentInformationDto;
			return this;
		}

		public Builder withGeneratedWarnings(List<Pair<InvalidOperationCode, Object[]>> generatedWarnings) {
			this.generatedWarnings = generatedWarnings;
			return this;
		}

		public CardOperationResultDto build() {
			return new CardOperationResultDto(this);
		}
	}

}