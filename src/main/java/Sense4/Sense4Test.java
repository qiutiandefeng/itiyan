/*
 * @(#)Sense4Test.java 1.0 08/01/24
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_1\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */
package Sense4;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Sense4Test extends Frame {
	
	public Sense4Test() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
	}
}


/*
�����µ�c ��SENSE4_CONTEXT�ṹ����java�ĵȼ۽ṹ��
typedef struct {
        DWORD 			dwIndex;//device index
        DWORD			dwVersion;//version
        HANDLE			hLock;//device handle
        BYTE			reserve[12];
        BYTE			bAtr[MAX_ATR_LEN];
        BYTE			bID[MAX_ID_LEN];
        DWORD			dwAtrLen;
}SENSE4_CONTEXT,*PSENSE4_CONTEXT;
*/

/*
typedef struct{
        WORD EfID;
        BYTE EfType;
        WORD EfSize;
}EFINFO,*PEFINFO;
*/
class EFINFO
{
        public short EfID;
        public byte EfType;
        public short EfSize;
}
/*
typedef struct _S4OPENINFO {
        DWORD dwS4OpenInfoSize;
        DWORD dwShareMode;
} S4OPENINFO;
*/
class S4OPENINFO
{
        public int dwS4OpenInfoSize;
        public int dwShareMode;
}
/*
typedef struct _S4CREATEDIRINFO {
        DWORD dwS4CreateDirInfoSize;
        BYTE  szAtr[8];
} S4CREATEDIRINFO;
*/
class S4CREATEDIRINFO
{
        public int dwS4CreateDirInfoSize;
        byte [] szAtr;
        S4CREATEDIRINFO()
        {
                szAtr = new byte[8];
        }
}
