package coursera.albertauniversity.designpatterns.week1;

import java.util.ArrayList;

public class Playlist implements IComponent {
  private String playlistName;
  private ArrayList<IComponent> playlist;

  public Playlist(String playlistName) {
    this.playlistName = playlistName;
    playlist = new ArrayList<>();
  }

  @Override
  public void play() {
    for (IComponent component : playlist) {
      component.play();
    }
  }

  @Override
  public void setPlaybackSpeed(float speed) {
    for (IComponent component : playlist) {
      component.setPlaybackSpeed(speed);
    }
  }

  @Override
  public String getName() {
    return playlistName;
  }

  public void add(IComponent component) {
    this.playlist.add(component);
  }

  public void remove(IComponent component) {
    this.playlist.remove(component);
  }
}
