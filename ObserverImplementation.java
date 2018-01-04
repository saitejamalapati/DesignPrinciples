package com.accolite.au;

import java.util.ArrayList;

interface Subscribe
{
	void update();
}

class Model
{
	String movie;
	int score;
	ArrayList<GetSubscription> subscribers=new ArrayList<GetSubscription>();
	void addSubscriber(GetSubscription subscriber)
	{
		subscribers.add(subscriber);
	}
}

class Score extends Model implements Subscribe
{
	void setScore(int score)
	{
		this.score=score;
		update();
	}
	
	public void update()
	{
		for(GetSubscription subscriber: subscribers)
		{
			subscriber.getUpdate(score);
		}
		display();
	}
	void display()
	{
		for(GetSubscription subscriber: subscribers)
			System.out.println(subscriber.score);
	}
}

class Movie extends Model implements Subscribe
{
	void setMovie(String movie)
	{
		this.movie=movie;
		update();
	}
	
	public void update()
	{
		for(GetSubscription subscriber: subscribers)
		{
			subscriber.getUpdate(movie);
		}
		display();
	}
	
	void display()
	{
		for(GetSubscription subscriber: subscribers)
			System.out.println(subscriber.movie);
	}
}

class GetSubscription extends Model
{
	void getUpdate(int score)
	{
		this.score=score;
	}
	
	void getUpdate(String movie)
	{
		this.movie=movie;
	}
	
	void subscribe(Model m)
	{
		m.addSubscriber(this);
	}
}

public class ObserverImplementation {
	public static void main(String args[])
	{
		Score score=new Score();
		GetSubscription gs1=new GetSubscription();
		GetSubscription gs2=new GetSubscription();
		GetSubscription gs3=new GetSubscription();
		GetSubscription gs4=new GetSubscription();
		gs1.subscribe(score);
		gs2.subscribe(score);
		gs3.subscribe(score);
		score.setScore(6);
		score.setScore(3);
		Movie movie=new Movie();
		gs1.subscribe(movie);
		gs2.subscribe(movie);
		movie.setMovie("Avengers");
		gs4.subscribe(movie);
		movie.setMovie("IronMan");
		score.setScore(4);
		gs4.subscribe(score);
		movie.setMovie("Spiderman");
		score.setScore(1);
		
	}
}
