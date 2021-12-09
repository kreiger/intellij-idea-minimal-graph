package com.example;

import com.intellij.openapi.graph.builder.CachedGraphDataModel;
import org.jetbrains.annotations.NotNull;

class MyCachedGraphDataModel extends CachedGraphDataModel<String, String> {
    @Override public @NotNull String getNodeName(String s) {
        return s;
    }

    @Override public @NotNull String getEdgeName(String s) {
        return s;
    }

    @Override public void buildGraph() {
        this.createNode(GraphPopupPostStartupActivity.HELLO);
        this.createNode(GraphPopupPostStartupActivity.WORLD);
        this.createEdge("Edge", GraphPopupPostStartupActivity.HELLO, GraphPopupPostStartupActivity.WORLD);
    }

}
