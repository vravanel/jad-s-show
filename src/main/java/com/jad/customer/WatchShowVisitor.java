package com.jad.customer;

import com.jad.show.*;

import java.util.List;

class WatchShowVisitor implements IShowVisitor {
    @Override
    public void visit(final MovieShow show) {
        System.out.printf("J'ai assisté au film %s de %s sorti en %s%n%n",
                show.getName(), show.getDirector(), show.getYearOfRelease());
    }

    @Override
    public void visit(final TheaterShow show) {
        System.out.printf("J'ai assisté à la pièce de théâtre %s de %s.%n", show.getName(), show.getDirector());
        System.out.printf("Il y avait : %s%n%n", join(show.getActors()));
    }

    @Override
    public void visit(final StreetShow show) {
        System.out.printf("J'ai assisté au spectacle de rue %s.%n", show.getName());
        System.out.printf("Il y avait : %s%n%n", join(show.getPerformers()));
    }

    @Override
    public void visit(final ConcertShow show) {
        System.out.printf("J'ai assisté au concert %s de %s%n%n", show.getName(), show.getArtist());
    }

    private static String join(final List<String> names) {
        final StringBuilder sb = new StringBuilder();
        for (final String name : names) {
            sb.append(name).append(", ");
        }
        return sb.toString();
    }
}
