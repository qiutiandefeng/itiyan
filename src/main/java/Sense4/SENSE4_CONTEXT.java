package Sense4;

public class SENSE4_CONTEXT
{
        public int dwIndex;
        public int dwVersion;
        public int hLock;
        public byte[] reserve;
        public byte[] bAtr;
        public byte[] bID;
        public int dwAtrLen;
        public SENSE4_CONTEXT()
        {
                reserve = new byte[12];
                bAtr = new byte[56];
                bID = new byte[8];
        }
}
