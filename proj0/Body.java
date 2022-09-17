public class Body{
	public double xxPos; //Its current x positin
	public double yyPos; //Its current y positon
	public double xxVel; //Its current velocity in the x direction
	public double yyVel; //Its current velocity in the y direction
	public double mass;  //Its mass
	public String imgFileName; //name of the file that corresponds to the image depict the image

	public Body(double xP, double yP, double xV, double yV, 
					double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body c){
		double dx = c.xxPos - xxPos;
		double dy = c.yyPos - yyPos;
		double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		return r;
	}

	public double calcForceExertedBy(Body d){
		double r = calcDistance(d);
		final double G = 6.67e-11; //constant 
		double force = G * (mass * (d.mass)) / (Math.pow(r, 2));
		return force;
	}

	public double calcForceExertedByX(Body e){
		double dx = e.xxPos - xxPos;
		double force = calcForceExertedBy(e);
		double r = calcDistance(e);
		double force_x = force * dx / r;
		return force_x;
	}

	public double calcForceExertedByY(Body f){
		double dy = f.yyPos - yyPos;
		double force = calcForceExertedBy(f);
		double r = calcDistance(f);
		double force_y = force * dy / r;
		return force_y;
	}

	public double calcNetForceExertedByX(Body[] g){
		double net_x = 0;
		for(int i = 0; i < g.length; i++){
			if(g[i].equals(this) == false){
				net_x += calcForceExertedByX(g[i]);
			}
		}
		return net_x;
	}

	public double calcNetForceExertedByY(Body[] h){
		double net_y = 0;
		for(int i = 0; i < h.length; i++){
			if(h[i].equals(this) == false){
				net_y += calcForceExertedByY(h[i]);
			}
		}
		return net_y;
	}

	public void update(double dt, double f_net_x, double f_net_y){
		double a_net_x = f_net_x / mass;
		double a_net_y = f_net_y / mass;
		double v_new_x = xxVel + dt * a_net_x;
		double v_new_y = yyVel + dt * a_net_y;
		double p_new_x = xxPos + dt * v_new_x;
		double p_new_y = yyPos + dt * v_new_y;
		xxPos = p_new_x;
		yyPos = p_new_y;
		xxVel = v_new_x;
		yyVel = v_new_y;
	}
}