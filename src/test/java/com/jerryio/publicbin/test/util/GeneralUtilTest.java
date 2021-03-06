package com.jerryio.publicbin.test.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Level;

import org.junit.Test;

import com.jerryio.publicbin.util.BukkitVersion;
import com.jerryio.publicbin.util.DateTime;
import com.jerryio.publicbin.util.MD5Checksum;
import com.jerryio.publicbin.util.PluginLog;


public class GeneralUtilTest {
    
    @Test
    public void testNewPluginLogInstance() {
        new PluginLog();
    }
    
    @Test
    public void testNewDateTimeInstance() {
        new DateTime();
    }
    
    @Test
    public void testNewMD5Instance() {
        new MD5Checksum();
    }
    
    @Test
    public void testNewBukkitVersionInstance() {
        new BukkitVersion();
    }
    
    @Test
    public void testIsSupportMethod() {
        BukkitVersion.setMockVersion("2.10.0-R0.1-SNAPSHOT");
        assertFalse(BukkitVersion.isSupport("2.16"));
        assertTrue(BukkitVersion.isSupport("2.10"));
        assertTrue(BukkitVersion.isSupport("2.8"));
        assertTrue(BukkitVersion.isSupport("1.16.2"));
        assertTrue(BukkitVersion.isSupport("1.16"));
        assertTrue(BukkitVersion.isSupport("1.15"));
        assertTrue(BukkitVersion.isSupport("1.11"));
        assertTrue(BukkitVersion.isSupport("1.9"));
        assertTrue(BukkitVersion.isSupport("1.8.9"));
        assertTrue(BukkitVersion.isSupport("1.8.3"));
        assertTrue(BukkitVersion.isSupport("1.8"));
        assertTrue(BukkitVersion.isSupport("1.1"));
        
        BukkitVersion.setMockVersion("1.16.2-R0.1-SNAPSHOT");
        assertFalse(BukkitVersion.isSupport("2.16"));
        assertFalse(BukkitVersion.isSupport("2.10"));
        assertFalse(BukkitVersion.isSupport("2.8"));
        assertTrue(BukkitVersion.isSupport("1.16.2"));
        assertTrue(BukkitVersion.isSupport("1.16"));
        assertTrue(BukkitVersion.isSupport("1.15"));
        assertTrue(BukkitVersion.isSupport("1.11"));
        assertTrue(BukkitVersion.isSupport("1.9"));
        assertTrue(BukkitVersion.isSupport("1.8.9"));
        assertTrue(BukkitVersion.isSupport("1.8.3"));
        assertTrue(BukkitVersion.isSupport("1.8"));
        assertTrue(BukkitVersion.isSupport("1.1"));
        
        BukkitVersion.setMockVersion("1.8.3-R0.1-SNAPSHOT");
        assertFalse(BukkitVersion.isSupport("2.16"));
        assertFalse(BukkitVersion.isSupport("2.10"));
        assertFalse(BukkitVersion.isSupport("2.8"));
        assertFalse(BukkitVersion.isSupport("1.16.2"));
        assertFalse(BukkitVersion.isSupport("1.16"));
        assertFalse(BukkitVersion.isSupport("1.15"));
        assertFalse(BukkitVersion.isSupport("1.11"));
        assertFalse(BukkitVersion.isSupport("1.9"));
        assertFalse(BukkitVersion.isSupport("1.8.9"));
        assertTrue(BukkitVersion.isSupport("1.8.3"));
        assertTrue(BukkitVersion.isSupport("1.8"));
        assertTrue(BukkitVersion.isSupport("1.1"));
    }
    
    @Test
    public void testPluginLog() {
        PluginLog.setLogger(null);
        
        PluginLog.setDebugEnabled(false);
        PluginLog.log(Level.ALL, "");
        PluginLog.logDebug(Level.ALL, "");
        PluginLog.info("");
        PluginLog.warn("");
        
        PluginLog.setDebugEnabled(true);
        PluginLog.log(Level.ALL, "");
        PluginLog.logDebug(Level.ALL, "");
        PluginLog.info("");
        PluginLog.warn("");
    }
}
