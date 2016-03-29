#include<cv.h>
#include"Camera.h"
#include "FastMatchTemplate.h"



int demarrerCamera() {
 	
	//Compteur
	int compteur = 0;

	// Touche clavier
	char key;

	// Image de référence
	 IplImage *image;

	// Image courante
	// IplImage *imageCourante;

	// Capture vidéo
	CvCapture *capture;
 
	// Ouvrir le flux vidéo
	//capture = cvCreateFileCapture("/path/to/your/video/test.avi"); // chemin pour un fichier
	capture = cvCreateCameraCapture(CV_CAP_ANY);
 
	// Vérifier si l'ouverture du flux est ok
	if (!capture) {
	   printf("Ouverture du flux vidéo impossible !\n");
	   return 1;
	}
 
	// Définition de la fenêtre
	cvNamedWindow("Camera my-XPS", CV_WINDOW_AUTOSIZE);

	printf("Definition du rectangle de selection ! \n");

	//Definition du Fond  :
	IplImage* img_fond = cvQueryFrame(capture);
	image = cvQueryFrame(capture);
	IplImage* img_tmp = cvCreateImage(cvSize(100, 100), img_fond->depth, img_fond->nChannels);
	cvSetImageROI( img_fond, cvRect( 2, 2, 100, 100 ));
	cvCopy(img_fond,img_tmp,0);
	cvResetImageROI(img_fond);
	cvResetImageROI(image);

	/*vector<CvPoint> foundPointsList;
	vector<double> confidencesList;
	 if( FastMatchTemplate(*image, *img_tmp, &foundPointsList, &confidencesList)){
			compteur ++;
			printf("Compteur : %i \n", compteur);
	 }*/
	IplImage* image_selection;
	// Boucle tant que l'utilisateur n'appuie pas sur la touche q (ou Q)
	int z=0;
	while(z<50/*key != 'q' && key != 'Q'*/) {
 
	   /* On récupère une image
	   image = cvQueryFrame(capture);
	   image_selection = cvCreateImage(cvSize(101, 101), img_fond->depth, img_fond->nChannels);
	   cvSetImageROI(image, cvRect( 2, 2, 101, 101 ));
	   cvCopy(image,image_selection,0);
	   cvResetImageROI(image);
	   cvResetImageROI(image_selection);*/
	   
	   image = cvQueryFrame(capture);
	   //Depart de la recherche :
	   vector<CvPoint> foundPointsList;
	   vector<double> confidencesList;

	   if(!FastMatchTemplate(*image, *img_tmp, &foundPointsList, &confidencesList) 
	   ){
			compteur ++;
			printf("Compteur  : %i \n", compteur);
	   }

	   // On affiche l'image dans une fenêtre
	   cvShowImage("Camera my-XPS", image);
	   // On attend 10ms

	   key = cvWaitKey(100);
	   z++;
 
	}
//creation d'un fichier XML
	FILE *file;
 	file=fopen("releve.xml","w");
	fprintf(file,"%s","<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
	fprintf(file,"%s","<RELEVE NOM=\"Releve\">\n");
	fprintf(file,"%s","\t<NB_VOITURES>");
	fprintf(file,"%d",compteur);
	fprintf(file,"%s","\t</NB_VOITURES>\n");
	fprintf(file,"%s","</RELEVE>");

	fclose(file);
	printf("%s","releve.xml cree\n");
	cvReleaseCapture(&capture);
	cvDestroyWindow("Camera my-XPS");

	return 0;
 
}


