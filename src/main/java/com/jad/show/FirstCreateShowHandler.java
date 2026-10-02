package com.jad.show;

import java.util.Map;

/** Head of the chain (singleton): handles MOVIE and links the other handlers. */
final class FirstCreateShowHandler extends CreateShowHandler {
    private static final FirstCreateShowHandler INSTANCE = new FirstCreateShowHandler();

    private FirstCreateShowHandler() {
        this.setNext(new CreateTheaterShowHandler())
                .setNext(new CreateStreetShowHandler())
                .setNext(new CreateConcertShowHandler());
    }

    static FirstCreateShowHandler getInstance() {
        return INSTANCE;
    }

    @Override
    protected ShowType getShowType() {
        return ShowType.MOVIE;
    }

    @Override
    protected IShow create(final Map<String, String> p) {
        return ShowFactory.makeMovieShow(p.get("name"), p.get("description"), p.get("director"),
                p.get("yearOfRelease"), MovieType.valueOf(p.get("movieType")));
    }
}
