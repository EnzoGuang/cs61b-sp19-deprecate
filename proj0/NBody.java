public class NBody{
	public static double readRadius(String args){
		In in = new In(args);
		int cnt_planet = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Body[] readBodies(String args){
		In in = new In(args);
		int cnt_planet = in.readInt();
		double radius = in.readDouble();
		Body[] planets = new Body[cnt_planet];
		for(int i = 0; i < cnt_planet; i++){
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String imgFile = in.readString();
			planets[i] = new Body(xPos, yPos, xVel, yVel, mass, imgFile);
		}
		return planets;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Body[] planets = readBodies(filename);
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "./images/starfield.jpg");
		//System.out.println("planets.length" + planets.length);
		for(int i = 0; i < planets.length; i++){
			planets[i].draw();
		}
		double time = 0;
		StdDraw.enableDoubleBuffering();
		while(time <= T){
			double[] xForce = new double[planets.length];
			double[] yForce = new double[planets.length];
			for(int i = 0; i < planets.length; i++){
				xForce[i] = planets[i].calcNetForceExertedByX(planets);
				yForce[i] = planets[i].calcNetForceExertedByY(planets);
				planets[i].update(dt, xForce[i], yForce[i]);
			}
			StdDraw.picture(0, 0, "./images/starfield.jpg");
			for(int j = 0; j <planets.length; j++){
				//StdDraw.clear();
				planets[j].draw();
				StdDraw.pause(1);
			}StdDraw.show();
			time += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}