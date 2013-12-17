package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.bounding.BoundingBox;
import com.jme3.bounding.BoundingVolume;
import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.shape.Box;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private class PlayerCollisionGeometry extends Geometry 
    {

        public PlayerCollisionGeometry() {
        }

        public PlayerCollisionGeometry(String name) {
            super(name);
        }

        public PlayerCollisionGeometry(String name, Mesh mesh) {
            super(name, mesh);
        }
        
    }
    
    Geometry boxGeom;
    Geometry playerGeom;
    
    Vector3f CurrentPlayerPosition;
    Vector3f LastPlayerPosition;
    Vector3f MovementVector;
    
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Box b = new Box(Vector3f.ZERO, 1, 1, 1);
        boxGeom = new Geometry("boxGeom", b);
        boxGeom.setLocalTranslation(5, 0, 0);
        
        Box p = new Box(Vector3f.ZERO, 1, 1, 1);
        playerGeom = new PlayerCollisionGeometry("playerGeom", p);
        playerGeom.setLocalTranslation(-5, 0, 0);
        
        Material matBox = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matBox.setColor("Color", ColorRGBA.Blue);
        boxGeom.setMaterial(matBox);
        boxGeom.setModelBound(new BoundingBox(boxGeom.getLocalTranslation(), 1, 1, 1));
        
        Material matPlayer = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        matPlayer.setColor("Color", ColorRGBA.Red);
        playerGeom.setMaterial(matPlayer);
        playerGeom.setMaterial(matBox);
        playerGeom.setModelBound(new BoundingBox(playerGeom.getLocalTranslation(), 1, 1, 1));
        
        rootNode.attachChild(boxGeom);
        rootNode.attachChild(playerGeom);
        
        MovementVector = new Vector3f(2, 0, 0);
        CurrentPlayerPosition = playerGeom.getLocalTranslation();
    }

    @Override
    public void simpleUpdate(float tpf) {
        playerGeom.updateModelBound();
        boxGeom.updateModelBound();
        
        // move player, do sth (mouse dir or keys) to change direction somewere else
        CurrentPlayerPosition.addLocal(MovementVector.mult(tpf));
        
        CollisionResults results = new CollisionResults();
        if (playerGeom.collideWith(boxGeom.getWorldBound(), results) > 0)
        {
            for (CollisionResult c : results)
            {
                if (c.getGeometry() instanceof PlayerCollisionGeometry)
                {
                    // reset position
                    playerGeom.setLocalTranslation(LastPlayerPosition);
                }
            }
        }
        else
        {
            playerGeom.setLocalTranslation(CurrentPlayerPosition);
            LastPlayerPosition = new Vector3f(CurrentPlayerPosition);
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
