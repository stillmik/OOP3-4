package Thanks;

// похвала
public class Praise extends Thank {

    private FormOfPraise form;
    Praise(String thankedFor,FormOfPraise form) {
        super(thankedFor);
        this.form=form;
    }
}
