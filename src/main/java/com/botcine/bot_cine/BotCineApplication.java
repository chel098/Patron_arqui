package com.botcine.bot_cine;


import com.botcine.bot_cine.chat.CineLongPollingBot;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.sql.DataSource;


@SpringBootApplication
@MapperScan("com.botcine.bot_cine")
public class BotCineApplication {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		return factoryBean.getObject();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BotCineApplication.class, args);
		try {
			//Inicializamos libreria de bots
			TelegramBotsApi telegramApi = new TelegramBotsApi(DefaultBotSession.class);
			//Registramos la implementacion de nuestro BOT
			telegramApi.registerBot(new CineLongPollingBot(context));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
