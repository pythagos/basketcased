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

package com.bc.search.entity.multimedia;

/**
 * The Enum VideoSortOption.
 */
public enum VideoSortOption {

    /** The RELEVANCE. */
    RELEVANCE("Relevance"),
    
    /** The DATE. */
    DATE("Date");
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new video sort option.
     * 
     * @param v the v
     */
    VideoSortOption(String v) {
        value = v;
    }

    /**
     * Value.
     * 
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value.
     * 
     * @param v the v
     * 
     * @return the video sort option
     */
    public static VideoSortOption fromValue(String v) {
        for (VideoSortOption c: VideoSortOption.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
