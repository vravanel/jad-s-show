package com.jad.show;

import java.util.Map;

final class CreateConcertShowHandler extends CreateShowHandler {
    @Override
    protected ShowType getShowType() {
        return ShowType.CONCERT;
    }

    @Override
    protected IShow create(final Map<String, String> p) {
        return ShowFactory.makeConcertShow(p.get("name"), p.get("description"), p.get("artist"));
    }
}
