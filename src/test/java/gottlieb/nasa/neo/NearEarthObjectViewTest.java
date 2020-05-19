package gottlieb.nasa.neo;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NearEarthObjectViewTest {

    @Test
    public void paintComponent_withNullNeo() {
        //given
        NearEarthObjectView view = new NearEarthObjectView();
        Graphics g = mock(Graphics.class);

        //when
        view.paintComponent(g);

        //then
        verifyNoInteractions(g);
    }

    @Test
    public void paintComponent_withNeoAwayFromMoon() {
        //given
        NearEarthObjectView view = new NearEarthObjectView();
        Graphics graphics = mock(Graphics.class);

        NeoFeed.nearEarthObjects neo = mock(NeoFeed.nearEarthObjects.class);
        doReturn(5.0).when(neo).closestLunarDistance();
        view.setNearEarthObjects(neo);

        //when
        view.paintComponent(graphics);

        //then

        //Earth
        verify(graphics).fillOval(-50, 200, 100, 100);
        //Asteroid
        verify(graphics).fillOval(-10, 200, 10, 10);
        //Moon
        verify(graphics).fillOval(-2, 200, 25, 25);
    }


}