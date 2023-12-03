package me.tWizT3d_dreaMr.PAutorank;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import com.djrapitops.plan.query.QueryService;

import me.armar.plugins.autorank.Autorank;
import me.armar.plugins.autorank.pathbuilder.Path;

public class PlayerJoin implements Listener {
    private Autorank plugin=(Autorank) Bukkit.getServer().getPluginManager().getPlugin("AutoRank");;
	@EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClick(PlayerJoinEvent e) {
		
		Player p=e.getPlayer();
		try {
		    QueryService queryService = QueryService.getInstance();
			Long lon=queryService.getCommonQueries().fetchPlaytime(p.getUniqueId(), UUID.fromString("eb349cd8-efc3-486c-9dee-35a2234ac09c"), -1701460804438l, 3701460804438l);
	    	lon=lon/60000;
	    	int i=lon.intValue();
	    	this.plugin.getPlayTimeStorageManager().setPlayerTime(p.getUniqueId(), i);
	    	List<Path> s=this.plugin.getPathManager().getActivePaths(p.getUniqueId());
	    	if(s.isEmpty()) {
	    		for(Path pa:this.plugin.getPathManager().getAllPaths())
	    		this.plugin.getPathManager().assignPath(pa, p.getUniqueId(), true);
	    	}
	    	
             
		} catch (IllegalStateException planIsNotEnabled) {
		    // Plan is not enabled, handle exception
		} 
    }
}
