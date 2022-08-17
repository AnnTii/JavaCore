package ObjectsClassesAndPackages.JavaCore_3_5_7_;

public abstract class KeywordAnalyzer implements TextAnalyzer {

    protected abstract String[] getKeywords();
    protected abstract Label getLabel();


    @Override
    public Label processText(String text) {
        for (String str : getKeywords()) {
            if (text.contains(str))
                return getLabel();
        }
        return Label.OK;
    }
}
