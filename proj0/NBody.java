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
		System.out.println("planets.length" + planets.length);
		for(int i = 0; i < planets.length; i++){
			planets[i].draw();
		}
	}
}