package com.wjc.assess.dto;

import java.util.List;

public class AnalysisWholeDto {
    private List<AnalysisDto> pie;
    private List<AnalyScoreDto> bar;

    public List<AnalysisDto> getPie() {
        return pie;
    }

    public void setPie(List<AnalysisDto> pie) {
        this.pie = pie;
    }

    public List<AnalyScoreDto> getBar() {
        return bar;
    }

    public void setBar(List<AnalyScoreDto> bar) {
        this.bar = bar;
    }
}
