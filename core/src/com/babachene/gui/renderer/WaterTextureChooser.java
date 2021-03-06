package com.babachene.gui.renderer;

import com.babachene.logic.data.LevelMap;
import com.babachene.logic.data.entities.Entity;
import com.babachene.logic.data.entities.EntityWater;

/* Utilisation:
 * 
 * Appeler WaterTextureChooser.texture(levelmap,x,y)
 * où (x,y) correspond aux coordonnées du bloc de water pour lequel on cherche une texture
 * ce qui renvoie la string correspondant à la bonne texture de water.
 * 
 */


public class WaterTextureChooser {
	private final static int[] hashtable= {
44,
44,
44,
44,
44,
44,
44,
44,
44,
44,
44,
44,
44,
44,
44,
44,
40,
40,
40,
40,
40,
40,
40,
40,
40,
40,
40,
40,
40,
40,
40,
40,
43,
43,
43,
43,
43,
43,
43,
43,
43,
43,
43,
43,
43,
43,
43,
43,
32,
33,
32,
33,
32,
33,
32,
33,
32,
33,
32,
33,
32,
33,
32,
33,
42,
42,
42,
42,
42,
42,
42,
42,
42,
42,
42,
42,
42,
42,
42,
42,
45,
45,
45,
45,
45,
45,
45,
45,
45,
45,
45,
45,
45,
45,
45,
45,
38,
38,
39,
39,
38,
38,
39,
39,
38,
38,
39,
39,
38,
38,
39,
39,
22,
21,
20,
16,
22,
21,
20,
16,
22,
21,
20,
16,
22,
21,
20,
16,
41,
41,
41,
41,
41,
41,
41,
41,
41,
41,
41,
41,
41,
41,
41,
41,
34,
34,
34,
34,
34,
34,
34,
34,
35,
35,
35,
35,
35,
35,
35,
35,
46,
46,
46,
46,
46,
46,
46,
46,
46,
46,
46,
46,
46,
46,
46,
46,
25,
23,
25,
23,
25,
23,
25,
23,
24,
17,
24,
17,
24,
17,
24,
17,
36,
36,
36,
36,
37,
37,
37,
37,
36,
36,
36,
36,
37,
37,
37,
37,
28,
28,
28,
28,
26,
26,
26,
26,
27,
27,
27,
27,
18,
18,
18,
18,
31,
31,
29,
29,
30,
30,
19,
19,
31,
31,
29,
29,
30,
30,
19,
19,
15,
12,
11,
6,
13,
8,
7,
2,
14,
10,
9,
3,
47, // A Rajouter!!!
5,
4,
1
};
	
	static int containsWater(LevelMap map,int x,int y,int hauteur,int largeur) {
		
		if (x<0 || x>=hauteur || y<0 || y>=largeur) {
			return 1;
		}
		for (Entity entity:map.getMapMatrix()[x][y].getEntityStack() ) {
			if (entity instanceof EntityWater) {
				return 1;
			}
		}
		return 0;
	}
	
	
	/*
	 * Same as texture(...) but only returns the index.
	 */
	static int index(LevelMap map,int x, int y) {
		
		boolean [][] v= new boolean [3][3]; // Voisins
		int hauteur=map.getMapMatrix().length;
		int largeur=map.getMapMatrix()[0].length;
		
		int voisins=0; // nombre entre 0 et 127 qui représente l'état des voisins
		
		x--; // Most magical line ever. Don't dare remove it.
		//calcul de voisins
		int[][] parcours = { {x-1,y},{x,y+1},{x+1,y},{x,y-1},{x-1,y-1},{x-1,y+1},{x+1,y+1},{x+1,y-1}};
		int xx,yy;
		for(int i=0;i<8;i++) {
			xx=parcours[i][0];
			yy=parcours[i][1];
			
			voisins+=containsWater(map,xx,yy,hauteur,largeur)* (int) Math.pow(2,(7-i));
			
		}
		return hashtable[voisins];
	}
	
	static String texture(LevelMap map,int x, int y) {
		
		boolean [][] v= new boolean [3][3]; // Voisins
		int hauteur=map.getMapMatrix().length;
		int largeur=map.getMapMatrix()[0].length;
		
		int voisins=0; // nombre entre 0 et 127 qui représente l'état des voisins
		
		//calcul de voisins
		int[][] parcours = { {-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
		int xx,yy;
		for(int i=0;i<8;i++) {
			xx=parcours[i][0];
			yy=parcours[i][1];
			
			voisins+=containsWater(map,xx,yy,hauteur,largeur)* (int) Math.pow(2,(7-i));
			
		}
		/*
		 * 
		 */
		return ("textures/water/water"+hashtable[voisins]+".png");
	}
	
}
