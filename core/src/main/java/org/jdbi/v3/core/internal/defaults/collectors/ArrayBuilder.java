/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdbi.v3.core.internal.defaults.collectors;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class ArrayBuilder {
    private Class<?> componentType;
    private List<Object> list = new ArrayList<>();

    ArrayBuilder(Class<?> componentType) {
        this.componentType = componentType;
    }

    void add(Object element) {
        list.add(element);
    }

    Object build() {
        Object array = Array.newInstance(componentType, list.size());
        for (int i = 0; i < list.size(); i++) {
            Array.set(array, i, list.get(i));
        }
        return array;
    }

    ArrayBuilder combine(ArrayBuilder other) {
        list.addAll(other.list);
        return this;
    }
}