package Models;

import android.graphics.Bitmap;

import java.sql.Blob;

public class Firmas {

    private Integer id;
    private String description;
    private Bitmap firma;

    public Firmas(){
    }

    public Firmas(Integer id, String description, Bitmap firma) {
        this.id = id;
        this.description = description;
        this.firma = firma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getFirma() {
        return firma;
    }

    public void setFirma(Bitmap firma) {
        this.firma = firma;
    }
}
