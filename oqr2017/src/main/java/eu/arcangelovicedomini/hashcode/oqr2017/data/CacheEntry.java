package eu.arcangelovicedomini.hashcode.oqr2017.data;

public class CacheEntry {

    private Video video;
    private long score;

    public CacheEntry(Video video, long score) {
        this.video = video;
        this.score = score;
    }

    public Video getVideo() {
        return video;
    }

    public long getScore() {
        return score;
    }
}
