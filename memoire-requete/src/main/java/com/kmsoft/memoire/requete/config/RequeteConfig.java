package com.kmsoft.memoire.requete.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaRequeteConfig.class)
public class RequeteConfig {

}