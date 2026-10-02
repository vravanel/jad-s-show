package com.jad.show;

import java.util.Map;

final class CreateStreetShowHandler extends CreateShowHandler {
    @Override
    protected ShowType getShowType() {
        return ShowType.STREET_SHOW;
    }

    @Override
    protected IShow create(final Map<String, String> p) {
        return ShowFactory.makeStreetShow(p.get("name"), p.get("description"), parseList(p.get("performers")));
    }
}
