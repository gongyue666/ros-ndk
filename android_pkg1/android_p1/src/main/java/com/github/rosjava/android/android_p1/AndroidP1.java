// package com.github.rosjava.android.android_p1;

// import android.app.Activity;
// import android.os.Bundle;

// public class AndroidP1 extends Activity
// {
//     /** Called when the activity is first created. */
//     @Override
//     public void onCreate(Bundle savedInstanceState)
//     {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.main);
//     }
// }


package com.github.rosjava.android.android_p1;

import org.ros.android.RosActivity;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;
import org.ros.RosCore;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.ros.rosjava_tutorial_native_node.ChatterNativeNode;
import java.net.URI;

public class AndroidP1 extends RosActivity
{
    private RosCore myRoscore;
    private Log log = LogFactory.getLog(AndroidP1.class);
    private NodeMainExecutor nodeMainExecutor = null;
    private URI masterUri;
    private String hostName;
    private ChatterNativeNode chatterNativeNode;
    final static String appName = "native_wrap_test";
    
    public AndroidP1()
    {
        super(appName, appName);        
    }
    
    @Override
    protected void init(NodeMainExecutor nodeMainExecutor)
    {
        log.info("AndroidP1 init");
        
        // Store a reference to the NodeMainExecutor and unblock any processes that were waiting
        // for this to start ROS Nodes
        this.nodeMainExecutor = nodeMainExecutor;
        masterUri = getMasterUri();
        hostName = getRosHostname();

        log.info(masterUri);

        startChatter();        
    }
    
    // Create a native chatter node
    private void startChatter()
    {
        log.info("Starting native node wrapper...");
        
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(hostName);
        
        nodeConfiguration.setMasterUri(masterUri);
        nodeConfiguration.setNodeName(ChatterNativeNode.nodeName);
        
        chatterNativeNode = new ChatterNativeNode();
        
        nodeMainExecutor.execute(chatterNativeNode, nodeConfiguration);
    }    
}