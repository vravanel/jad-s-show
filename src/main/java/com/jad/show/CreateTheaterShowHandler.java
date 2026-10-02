package com.jad.show;

import java.util.Map;

final class CreateTheaterShowHandler extends CreateShowHandler {
    @Override
    protected ShowType getShowType() {
        return ShowType.THEATER;
    }

    @Override
    protected IShow create(final Map<String, String> p) {
        return ShowFactory.makeTheaterShow(p.get("name"), p.get("description"), p.get("director"),
                parseList(p.get("actors")));
    }
}
