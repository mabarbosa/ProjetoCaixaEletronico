package br.com.usjt.view.arq;

public class ComboBancoItem
{
    private String codBanco;
    private String label;

    public ComboBancoItem(String codBanco, String label) {
        this.codBanco = codBanco;
        this.label = label;
    }

    public String getCodBanco() {
        return this.codBanco;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label;
    }
}