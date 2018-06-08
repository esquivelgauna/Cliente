package clientepc;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import java.util.ArrayList;

public class cliente {
    
    public static boolean b1 = false;
    

    public static void main(String[] args) throws Exception
    {
        //getSystemStatistics();
        ArrayList<String> Datos;
        Datos = new ArrayList<>();
        InetAddress ip;
        Sigar sigar;
        sigar = new Sigar();
        Mem memoria = sigar.getMem();
        CpuInfo[] infos =null;
        CpuPerc[] cpus = null;
        String IPA = null;
        try {
            infos = sigar.getCpuInfoList();
            cpus = sigar.getCpuPercList();
            ip = InetAddress.getLocalHost();
            IPA = ip.getHostAddress();
            //System.out.println("Current IP address : " + ip.getHostAddress());
	
        } catch (SigarException e) {
            e.printStackTrace();
        }
        CpuInfo info = infos[0];
        ObjectOutputStream DDatos= null;
        OperatingSystem sys = OperatingSystem.getInstance();
        Socket s = null;
        
        try
        {
            s = new Socket("127.0.0.1", 5434);
            
            DDatos = new ObjectOutputStream( s.getOutputStream() );
            
            Datos.add( (String) sys.getDescription() );
            Datos.add( (String) sys.getName() );
            Datos.add(  info.getVendor() );
            Datos.add(  info.getModel() );
            Datos.add( String.valueOf(  info.getMhz() )   );
            Datos.add( String.valueOf(  info.getTotalCores() ) );
            Datos.add( String.valueOf(  CpuPerc.format(sigar.getCpuPerc().getUser())  ) );
            Datos.add( String.valueOf( (memoria.getTotal())/1024/1000)  );
            Datos.add( String.valueOf( (memoria.getFree())/1024/1000 )  );
            Datos.add( String.valueOf( (memoria.getUsed())/1024/1000 )  );
            Datos.add( ( IPA ) );
            //System.out.println(Datos);
            DDatos.writeObject(Datos);
         
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(s != null) s.close();
            System.out.println("Conexion cerrada!");
        }
    }
    
    public static void getSystemStatistics() {
        
        Mem mem = null;
        CpuInfo[] cores = null ;
        CpuPerc cpuperc = null;
        FileSystemUsage filesystemusage = null;
        Sigar sigar;
        sigar = new Sigar();

        try {
            mem = sigar.getMem();
            cpuperc = sigar.getCpuPerc();
            filesystemusage = sigar.getFileSystemUsage("C:");
            cores = sigar.getCpuInfoList();
        } catch (SigarException se) {
            se.printStackTrace();
        }
        CpuInfo Core = cores[0];
        System.out.print("Memoria usada %: " + mem.getUsedPercent() + "\n" );
        System.out.print( "CPU usado %: " +  (cpuperc.getCombined() * 100 ) + "\n" );
        System.out.print( "Nucleos : " +  (Core.getTotalCores()) + "\n" );
        //System.out.print(filesystemusage.getUsePercent() + "\n");
    }
}
