#include<cmath>
#include<SFML/Graphics.hpp>
using namespace sf;

class Player {
	private:
			const float START_SPEED=200;
			const float START_HEALTH=100;
		
			Vector2f m_Position; //Position of the player
			Sprite m_Sprite;
			Texture m_Texture;
			Vector2f m_Resolution;
			IntRect m_Arena;
			int m_tileSize;
			bool m_UpPressed;
			bool m_DownPressed;
			bool m_LeftPressed;
			bool m_RightPressed;
			
			int m_Health;
			int m_MaxHealth;
			
			Time m_LastHit;
			float m_Speed;
			
	public:
			Player();
			void spawn(IntRect arena, Vector2f resolution, int tileSize);
			bool hit(Time timeHit);
			Time getLastHitTime();
			FloatRect getPosition();
			Vector2f getCenter();
			float getRotation();
			Sprite getSprite();
			int getHealth();
			void moveRight();
			void moveLeft();
			void moveUp();
			void moveDown();
			void stopLeft();
			void stopRight();
			void stopUp();
			void stopDown();
			void update(float elapsedTime,Vector2i mousePosition);
			void upgradeSpeed();
			void upgradeHealth();
			void increaseHealthLevel(int amount);
			void resetPlayerStats();
			
};

Player::Player(){
	m_Speed=START_SPEED;
	m_Health=START_HEALTH;
	
	m_MaxHealth=START_HEALTH;
	m_Texture.loadFromFile("graphics/player.png");
	m_Sprite.setTexture(m_Texture);
	
	m_Sprite.setOrigin(25,25);
	
}

void Player::spawn(IntRect arena, Vector2f resolution, int TileSize){
	m_Position.x=arena.width/2;
	m_Position.y=arena.height/2;
	
	m_Arena.left=arena.left;
	m_Arena.width=arena.width;
	m_Area.top=arena.top;
	m_Arena.height=arena.height;
	
	m_TileSize=tileSize;
	m_resolution.x=resolution.x;
	m_resolution.y=resolution.y;
}

Time Player::getLastHitTime(){
	return m_LastHit;
}

bool Player::hit(Time timeHit){
	if(timeHit.asMilliSeconds()-m_LastHit.asMilliSeconds()>200){
		m_LastHit=timeHit;
		m_Health-=1;
		return true;
	}else{
		return false;
	}
}

FloatRect Player::getPosition(){
	return m_Sprite.getGlobalBounds();
}

Vector2f Player::getCenter(){
	return m_Position;
}

float Player::getRotation(){
	return Sprite.getRotation();
}

float Player::getSprite(){
	return m_Sprite;
}
int Player::getHealth(){
	return m_Health;
}
void Player::moveLeft(){
	m_LeftPressed=true;
}

void Player::moveRight(){
	m_RightPressed=true;
}

void Player::moveUp(){
	m_UpPressed=true;
}
void Player::moveDown(){
	m_DownPressed=true;
}

void Player::stopLeft(){
	m_LeftPressed=false;
}
void Player::stopRight(){
	m_RightPressed=false;
}
void Player::stopUp(){
	m_UpPressed=false;
}
void Player::stopDown(){
	m_DownPressed=false;
}

void Player::update(float elapsedTime,Vector2i mousePosition){
	if(m_UpPressed){
		m_Position.y-=m_Speed*elapsedTime;
	}
	if(m_DownPressed){
		m_Position.y+= m_Speed *elapsedTime;
	}
	if(m_RightPressed){
		m_Position.x+=m_Speed*elapsedTime;
	}
	if(m_LeftPressed){
		m_Position.x-=m_Speed*elapsedTime;
	}
	m_Sprite.setPosition(m_Position);
	
	if(m_Position.x>m_Arena.width){
	
	}
}


