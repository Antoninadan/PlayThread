import com.mainacad.model.Song;
import com.mainacad.service.Player;
import com.mainacad.thread.SongStarter;

public class Main {

    public static void main(String[] args) {
        Song song1 = new Song("name", "author", 6);
        Player.work(song1);

    }
}
