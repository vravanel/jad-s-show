package com.jad.show;

import java.util.HashMap;
import java.util.Map;

abstract class CreateShowHandler {
    private CreateShowHandler next;

    final CreateShowHandler setNext(final CreateShowHandler next) {
        this.next = next;
        return next;
    }

    final IShow handle(final String showDescription) {
        final int separator = showDescription.indexOf(':');
        if (separator < 0) {
            throw new IllegalArgumentException("Invalid show description: " + showDescription);
        }
        if (showDescription.substring(0, separator).trim().equals(this.getShowType().name())) {
            return this.create(parseParameters(showDescription.substring(separator + 1)));
        }
        if (this.next == null) {
            throw new IllegalArgumentException("Unknown show type in: " + showDescription);
        }
        return this.next.handle(showDescription);
    }

    protected abstract ShowType getShowType();

    protected abstract IShow create(Map<String, String> parameters);

    /** Splits "key=value;key=value" into a map. */
    private static Map<String, String> parseParameters(final String parameters) {
        final Map<String, String> result = new HashMap<>();
        for (final String parameter : parameters.split(";")) {
            final int equals = parameter.indexOf('=');
            if (equals > 0) {
                result.put(parameter.substring(0, equals).trim(), parameter.substring(equals + 1).trim());
            }
        }
        return result;
    }

    /** Splits "a,b,c" into an array. */
    protected static String[] parseList(final String list) {
        return list == null || list.isBlank() ? new String[0] : list.trim().split("\\s*,\\s*");
    }
}
