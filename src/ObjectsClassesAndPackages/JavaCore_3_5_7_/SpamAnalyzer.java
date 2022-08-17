package ObjectsClassesAndPackages.JavaCore_3_5_7_;

public class SpamAnalyzer extends KeywordAnalyzer {

    private String[] keywords;
    private Label label;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
        label = Label.SPAM;
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
