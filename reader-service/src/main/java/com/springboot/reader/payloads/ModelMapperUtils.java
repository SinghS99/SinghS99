package com.springboot.reader.payloads;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
    public class ModelMapperUtils extends ModelMapper{
        public ModelMapperUtils() {       
        this.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        }   
    }

