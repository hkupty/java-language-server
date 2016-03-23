package com.fivetran.javac.message;

import com.fivetran.javac.LineMap;
import com.sun.tools.javac.code.Symbol;

import javax.tools.JavaFileObject;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

public class Location {
    public final String uri;
    public final Range range;

    public Location(String uri, Range range) {
        this.uri = uri;
        this.range = range;
    }

    public Location(String uri, int fromLine, int fromCharacter, int toLine, int toCharacter) {
        this(uri, new Range(new Position(fromLine, fromCharacter), new Position(toLine, toCharacter)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(uri, location.uri) &&
               Objects.equals(range, location.range);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, range);
    }

    @Override
    public String toString() {
        return uri + " " + range;
    }
}
