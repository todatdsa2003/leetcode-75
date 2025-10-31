class TextEditor {
    StringBuilder left;
    StringBuilder right;

    public TextEditor() {
        left = new StringBuilder();
        right = new StringBuilder();
    }

    public void addText(String text) {
        left.append(text);
    }

    public int deleteText(int k) {
        int deleted = Math.min(k, left.length());
        left.setLength(left.length() - deleted);
        return deleted;
    }

    public String cursorLeft(int k) {
        int moved = Math.min(k, left.length());
        for (int i = 0; i < moved; i++) {
            right.append(left.charAt(left.length() - 1));
            left.setLength(left.length() - 1);
        }
        return getLeftText();
    }

    public String cursorRight(int k) {
        int moved = Math.min(k, right.length());
        for (int i = 0; i < moved; i++) {
            left.append(right.charAt(right.length() - 1));
            right.setLength(right.length() - 1);
        }
        return getLeftText();
    }

    private String getLeftText() {
        int start = Math.max(0, left.length() - 10);
        return left.substring(start);
    }
}