package com.jcav22.problems.logic;

import com.jcav22.problems.model.Point2D;
import com.jcav22.problems.model.Rectangle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OverlappingAreaInRectanglesTest {

    @ParameterizedTest
    @MethodSource("rectanglesProvider")
    public void getOverlappingAreaTest(Rectangle r1, Rectangle r2, int expectedArea) {
        assertEquals(expectedArea, OverlappingAreaInRectangles.getOverlappingArea(r1, r2));
    }

    private static Rectangle getRectangle(int x1, int y1, int x2, int y2) {
        return new Rectangle(new Point2D(x1, y1), new Point2D(x2, y2));
    }

    private static Stream<Arguments> rectanglesProvider() {
        return Stream.of(
                Arguments.of( // No overlap
                        getRectangle(1, 1, 3, 3),
                        getRectangle(3, 3, 5, 5),
                        0
                ),
                Arguments.of( // top right
                        getRectangle(1, 1, 4, 4),
                        getRectangle(3, 3, 5, 5),
                        1
                ),
                Arguments.of( // top right
                        getRectangle(1, 3, 6, 7),
                        getRectangle(4, 5, 8, 8),
                        4
                ),
                Arguments.of( // Top Left
                        getRectangle(1, 1, 4, 4),
                        getRectangle(0, 3, 3, 5),
                        2
                ),
                Arguments.of( // Bottom Right
                        getRectangle(1, 3, 6, 7),
                        getRectangle(4, 1, 8, 5),
                        4
                ),
                Arguments.of( // Bottom Left
                        getRectangle(1, 1, 4, 4),
                        getRectangle(0, 0, 2, 2),
                        1
                ),
                Arguments.of( // R2 inside R1
                        getRectangle(1, 1, 4, 4),
                        getRectangle(2, 2, 3, 3),
                        1
                ),
                Arguments.of( // R1 inside R2
                        getRectangle(2, 2, 3, 3),
                        getRectangle(1, 1, 4, 4),
                        1
                ),
                Arguments.of( // Negative value
                        getRectangle(1, 1, 3, 3),
                        getRectangle(-1, -1, 3, 3),
                        4
                )
        );
    }
}