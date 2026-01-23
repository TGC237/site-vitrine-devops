# Guide de Contribution

Merci de votre intérêt pour contribuer à ce projet ! Voici quelques lignes directrices pour vous aider.

## 🚀 Comment Contribuer

### 1. Fork le projet

Cliquez sur le bouton "Fork" en haut à droite de la page du repository.

### 2. Clonez votre fork

```bash
git clone https://github.com/VOTRE-USERNAME/site-vitrine-devops.git
cd site-vitrine-devops
```

### 3. Créez une branche

```bash
git checkout -b feature/ma-nouvelle-fonctionnalite
```

### 4. Faites vos modifications

- Assurez-vous que votre code suit les standards du projet
- Testez vos modifications localement
- Ajoutez des commentaires si nécessaire

### 5. Testez avec Docker

```bash
docker-compose up -d
# Vérifiez que tout fonctionne sur http://localhost:8080
docker-compose down
```

### 6. Committez vos changements

```bash
git add .
git commit -m "feat: description de votre fonctionnalité"
```

### Conventions de commit

Nous utilisons les conventions suivantes pour les messages de commit :

- `feat:` Nouvelle fonctionnalité
- `fix:` Correction de bug
- `docs:` Documentation uniquement
- `style:` Changements de formatage (ne change pas le code)
- `refactor:` Refactoring du code
- `test:` Ajout ou modification de tests
- `chore:` Maintenance du code

### 7. Push vers votre fork

```bash
git push origin feature/ma-nouvelle-fonctionnalite
```

### 8. Créez une Pull Request

Allez sur le repository original et cliquez sur "New Pull Request".

## 📋 Standards de Code

### HTML

- Utilisez HTML5 sémantique
- Indentation de 4 espaces
- Attributs alt pour toutes les images

### CSS

- Utilisez des variables CSS pour les couleurs
- Mobile-first design
- Commentez les sections importantes

### JavaScript

- Utilisez ES6+
- Pas de console.log en production (sauf messages intentionnels)
- Commentez les fonctions complexes

## 🧪 Tests

Avant de soumettre une PR :

1. Testez localement dans votre navigateur
2. Testez avec Docker : `docker-compose up`
3. Vérifiez la responsive design (mobile, tablette, desktop)
4. Assurez-vous que le pipeline CI/CD passe

## 🐛 Rapporter des Bugs

Si vous trouvez un bug :

1. Vérifiez qu'il n'a pas déjà été rapporté dans les Issues
2. Créez une nouvelle Issue avec :
   - Description claire du bug
   - Étapes pour reproduire
   - Comportement attendu vs comportement actuel
   - Captures d'écran si pertinent
   - Environnement (navigateur, OS, etc.)

## 💡 Suggestions

Les suggestions d'amélioration sont les bienvenues ! Créez une Issue avec le label "enhancement".

## 📝 License

En contribuant, vous acceptez que vos contributions soient sous la même licence que le projet (MIT).

## ❓ Questions

Si vous avez des questions, n'hésitez pas à ouvrir une Issue avec le label "question".

Merci de contribuer ! 🙏
