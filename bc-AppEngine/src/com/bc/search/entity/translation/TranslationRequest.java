/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.bc.search.entity.translation;

import com.bc.search.entity.SchemaEntity;

/**
 * The Class TranslationRequest.
 */
public class TranslationRequest 
	extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7166387890864766402L;
	
	/** The source language. */
	protected String sourceLanguage;
    
    /** The target language. */
    protected String targetLanguage;

    /**
     * Gets the source language.
     * 
     * @return the source language
     */
    public String getSourceLanguage() {
        return sourceLanguage;
    }

    /**
     * Sets the source language.
     * 
     * @param value the new source language
     */
    public void setSourceLanguage(String value) {
        this.sourceLanguage = value;
    }

    /**
     * Gets the target language.
     * 
     * @return the target language
     */
    public String getTargetLanguage() {
        return targetLanguage;
    }

    /**
     * Sets the target language.
     * 
     * @param value the new target language
     */
    public void setTargetLanguage(String value) {
        this.targetLanguage = value;
    }

}