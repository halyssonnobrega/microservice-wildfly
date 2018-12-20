package pt.link.sc.transaction.api.common.util;

import java.util.Locale;

public interface Labeled {

    /**
     * Get the label resource key for this value
     * Use this to get i18n label values
     */
    String getLabelResourceId();

    default String getFluentLabelResourceId() {
        return getLabelResourceId();
    }

    /**
     * Get the label for this value in the given locale
     */
    default String toLabel(Locale locale) {
        return MessageBundles.getDataMessage(getLabelResourceId(), locale);
    }

    default String toFluentLabel(Locale locale) {
        return MessageBundles.getDataMessage(getFluentLabelResourceId(), locale);
    }
}
