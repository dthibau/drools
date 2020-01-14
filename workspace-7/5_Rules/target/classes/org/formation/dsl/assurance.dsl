#/ debug:  usage

[*][]null=null
[keyword][]règle=rule
[keyword][]quand=when
[keyword][]alors=then
[keyword][]fin=end
[condition][]Age du conducteur est compris entre {min} et {max} ans=c  :  Conducteur(age >= {min})  &&  Conducteur(age <= {max})
[condition][]Pour une assurance=a  :  Assurance()
[consequence][]Le prix de base est {prix}=a.setPrixBase({prix});
[condition][]Conducteur a {ans} ans d ancienneté=c : Conducteur(  anciennete  >= {ans})
[consequence][]La remise est de {valeur}%=a.setRemise( a.getRemise() + {valeur}d );
[condition][]Pour un conducteur=c : Conducteur()
[consequence][]Le malus est incident fois {facteur}=a.setRemise( a.getRemise() - c.getIncidents()*{facteur});
