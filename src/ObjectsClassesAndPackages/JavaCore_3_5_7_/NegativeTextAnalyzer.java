package ObjectsClassesAndPackages.JavaCore_3_5_7_;

public class NegativeTextAnalyzer extends KeywordAnalyzer {

    private String[] keywords;
    private Label label;

    public NegativeTextAnalyzer() {
        keywords = new String[3];
        keywords[0] = ":(";
        keywords[1] = "=(";
        keywords[2] = ":|";
        label = Label.NEGATIVE_TEXT;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    public Label getLabel() {
        return label;
    }
}
