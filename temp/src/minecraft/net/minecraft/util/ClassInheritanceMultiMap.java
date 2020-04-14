package net.minecraft.util;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.optifine.util.IteratorCache;

public class ClassInheritanceMultiMap<T> extends AbstractSet<T> {
   private static final Set<Class<?>> field_181158_a = Collections.newSetFromMap(new ConcurrentHashMap());
   private final Map<Class<?>, List<T>> field_180218_a = Maps.newHashMap();
   private final Set<Class<?>> field_180216_b = Sets.newIdentityHashSet();
   private final Class<T> field_180217_c;
   private final List<T> field_181745_e = Lists.newArrayList();
   public boolean empty;

   public ClassInheritanceMultiMap(Class<T> p_i45909_1_) {
      this.field_180217_c = p_i45909_1_;
      this.field_180216_b.add(p_i45909_1_);
      this.field_180218_a.put(p_i45909_1_, this.field_181745_e);
      Iterator i$ = field_181158_a.iterator();

      while(i$.hasNext()) {
         Class<?> oclass = (Class)i$.next();
         this.func_180213_a(oclass);
      }

      this.empty = this.field_181745_e.size() == 0;
   }

   protected void func_180213_a(Class<?> p_180213_1_) {
      field_181158_a.add(p_180213_1_);
      int count = this.field_181745_e.size();

      for(int i = 0; i < count; ++i) {
         T t = this.field_181745_e.get(i);
         if (p_180213_1_.isAssignableFrom(t.getClass())) {
            this.func_181743_a(t, p_180213_1_);
         }
      }

      this.field_180216_b.add(p_180213_1_);
   }

   protected Class<?> func_181157_b(Class<?> p_181157_1_) {
      if (this.field_180217_c.isAssignableFrom(p_181157_1_)) {
         if (!this.field_180216_b.contains(p_181157_1_)) {
            this.func_180213_a(p_181157_1_);
         }

         return p_181157_1_;
      } else {
         throw new IllegalArgumentException("Don't know how to search for " + p_181157_1_);
      }
   }

   public boolean add(T p_add_1_) {
      Iterator i$ = this.field_180216_b.iterator();

      while(i$.hasNext()) {
         Class<?> oclass = (Class)i$.next();
         if (oclass.isAssignableFrom(p_add_1_.getClass())) {
            this.func_181743_a(p_add_1_, oclass);
         }
      }

      this.empty = this.field_181745_e.size() == 0;
      return true;
   }

   private void func_181743_a(T p_181743_1_, Class<?> p_181743_2_) {
      List<T> list = (List)this.field_180218_a.get(p_181743_2_);
      if (list == null) {
         this.field_180218_a.put(p_181743_2_, Lists.newArrayList(p_181743_1_));
      } else {
         list.add(p_181743_1_);
      }

      this.empty = this.field_181745_e.size() == 0;
   }

   public boolean remove(Object p_remove_1_) {
      T t = p_remove_1_;
      boolean flag = false;
      Iterator i$ = this.field_180216_b.iterator();

      while(i$.hasNext()) {
         Class<?> oclass = (Class)i$.next();
         if (oclass.isAssignableFrom(t.getClass())) {
            List<T> list = (List)this.field_180218_a.get(oclass);
            if (list != null && list.remove(t)) {
               flag = true;
            }
         }
      }

      this.empty = this.field_181745_e.size() == 0;
      return flag;
   }

   public boolean contains(Object p_contains_1_) {
      return Iterators.contains(this.func_180215_b(p_contains_1_.getClass()).iterator(), p_contains_1_);
   }

   public <S> Iterable<S> func_180215_b(final Class<S> p_180215_1_) {
      return new Iterable<S>() {
         public Iterator<S> iterator() {
            List<T> list = (List)ClassInheritanceMultiMap.this.field_180218_a.get(ClassInheritanceMultiMap.this.func_181157_b(p_180215_1_));
            if (list == null) {
               return Iterators.emptyIterator();
            } else {
               Iterator<T> iterator = list.iterator();
               return Iterators.filter(iterator, p_180215_1_);
            }
         }
      };
   }

   public Iterator<T> iterator() {
      return (Iterator)(this.field_181745_e.isEmpty() ? Iterators.emptyIterator() : IteratorCache.getReadOnly(this.field_181745_e));
   }

   public int size() {
      return this.field_181745_e.size();
   }

   public boolean isEmpty() {
      return this.empty;
   }
}
