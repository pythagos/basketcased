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
 * The Class TranslationResult.
 */
public class TranslationResult
    extends SchemaEntity
{
    
    /** The Constant serialVersionUID. */
    private final static long serialVersionUID = 2461660169443089969L;
    
    /** The translated term. */
    protected String translatedTerm;

    /**
     * Gets the translated term.
     * 
     * @return the translated term
     */
    public String getTranslatedTerm() {
        return translatedTerm;
    }

    /**
     * Sets the translated term.
     * 
     * @param value the new translated term
     */
    public void setTranslatedTerm(String value) {
        this.translatedTerm = value;
    }
}
