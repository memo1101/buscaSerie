package buscadordeseries;

import java.util.Date;
import java.util.List;

public class Serie extends Entidad {
    private int id;
    private String title;
    private String mediaType;
    private int eps;
    private String startYr;
    private String finishYr;
    private String sznOfRelease;
    private String description;
    private String studios;
    private List<String> tags;
    private int like;
    private int dislike;

    public Serie(int id,String title, String mediaType, int eps, String  startYr, String  finishYr, String sznOfRelease, String description, String studios, List<String> tags, int like, int dislike) {
        this.id=id;
        this.title = title;
        this.mediaType = mediaType;
        this.eps = eps;
        this.startYr = startYr;
        this.finishYr = finishYr;
        this.sznOfRelease = sznOfRelease;
        this.description = description;
        this.studios = studios;
        this.tags = tags;
        this.like = like;
        this.dislike = dislike;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public int getEps() {
        return eps;
    }

    public void setEps(int eps) {
        this.eps = eps;
    }

    public String getStartYr() {
        return startYr;
    }

    public void setStartYr(String startYr) {
        this.startYr = startYr;
    }

    public String getFinishYr() {
        return finishYr;
    }

    public void setFinishYr(String finishYr) {
        this.finishYr = finishYr;
    }

    public String getSznOfRelease() {
        return sznOfRelease;
    }

    public void setSznOfRelease(String sznOfRelease) {
        this.sznOfRelease = sznOfRelease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudios() {
        return studios;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }
    public void aumentarLike(){
        this.like++;
    }
    public void aumentarDislike(){
        this.dislike++;
    }
}
