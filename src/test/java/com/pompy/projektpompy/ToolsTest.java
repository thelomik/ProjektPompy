package com.pompy.projektpompy;

import javafx.scene.control.TextField;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ToolsTest {
    /**
     * Method under test: {@link Tools#saveToJason(TextField)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveToJason() {
        // TODO: Complete this test.
        //   Reason: R006 Static initializer failed.
        //   The static initializer of
        //   javafx.scene.Node
        //   threw java.lang.RuntimeException while trying to load it.
        //   Make sure the static initializer of Node
        //   can be executed without throwing exceptions.
        //   Exception: java.lang.RuntimeException: No toolkit found
        //       at com.sun.javafx.tk.Toolkit.getToolkit(Toolkit.java:278)
        //       at com.sun.javafx.perf.PerformanceTracker.logEvent(PerformanceTracker.java:100)
        //       at javafx.scene.Node.<clinit>(Node.java:417)

        // Arrange
        // TODO: Populate arranged inputs
        TextField textField = null;

        // Act
        Tools.saveToJason(textField);

        // Assert
        // TODO: Add assertions on result
    }
}

