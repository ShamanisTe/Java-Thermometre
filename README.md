Java-Thermometre
================

Application réalise à l'IUT de Lannion 22300 pour représenter un thermomètre


Structure
=========

Ce projet possède 4 classes

ThermoBouton : Un JPanel à mettre dans une JFrame qui va permettre de gérer la température du thermomètre

Thermometre : Une simple class qui contient les informations essentiels d'un thermomètre

ThermoDessin : Un JPanel à mettre dans une JFrame qui va représenter visuellement le thermomètre et qui se sert de la méthode paint de java.awt.Graphics pour le modéliser

ThermoSouris : extend de ThermoDessin, on ajoute des contrôles à la souris comme déplacer le thermomètre dans l'espace, modifier la températeur avec la molette
