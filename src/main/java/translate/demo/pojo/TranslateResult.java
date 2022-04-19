package translate.demo.pojo;

public class TranslateResult {
    private String src;
    private String ret;

    public TranslateResult() {
    }

    public TranslateResult(String src, String ret) {
        this.src = src;
        this.ret = ret;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    @Override
    public String toString() {
        return "TranslateResult{" +
                "src='" + src + '\'' +
                ", ret='" + ret + '\'' +
                '}';
    }
}
