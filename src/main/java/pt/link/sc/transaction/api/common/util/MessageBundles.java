package pt.link.sc.transaction.api.common.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * From SDS project
 * <p>
 * Message bundle repository
 * <p>
 * Only one message repository
 *
 * @author jose.damaso
 * @author mario.macarico
 */
public class MessageBundles {

    private final static Object[] EMPTY_ARRAY = new Object[]{};

    public static final String MESSAGE_BUNDLE_DATA = "dataLabels";


    public static String getDataMessage(String key, Locale locale) {
        return getMessage(MESSAGE_BUNDLE_DATA, key, locale).orElse(null);
    }

    private static Optional<String> getMessage(String bundleName, String key, Locale locale) {
        return formatMessage(bundleName, key, locale, EMPTY_ARRAY);
    }

    private static Optional<String> formatMessage(String bundleName, String key, Locale locale, Object... params) {
        final ResourceBundle bundle = getBundle(bundleName, locale);

        if (bundle.containsKey(key))
            return Optional.of(MessageFormat.format(bundle.getString(key), params));
        else
            return Optional.empty();
    }

    private static ResourceBundle getBundle(String name, Locale locale) {
        return ResourceBundle.getBundle(name, locale);
    }
}
